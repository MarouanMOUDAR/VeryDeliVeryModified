package controller;

import bean.Reclamation;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.ReclamationFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("reclamationController")
@SessionScoped
public class ReclamationController implements Serializable {

    @EJB
    private service.ReclamationFacade ejbFacade;
    private List<Reclamation> items = null;
    private Reclamation selected;
    private List<Reclamation> reclamationsAdmin;
    private List<Reclamation> reclamValid;

    public ReclamationController() {
    }

    public Reclamation getSelected() {
        return selected;
    }

    public void setSelected(Reclamation selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ReclamationFacade getFacade() {
        return ejbFacade;
    }

    public Reclamation prepareCreate() {
        selected = new Reclamation();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ReclamationCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ReclamationUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ReclamationDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Reclamation> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public void testReclamationValid(Reclamation reclamation) {
        reclamation.setDateTraitement(new Date());
        getFacade().edit(reclamation);
        reclamationsAdmin.remove(reclamationsAdmin.indexOf(reclamation));
    }
   
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Reclamation getReclamation(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Reclamation> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Reclamation> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Reclamation.class)
    public static class ReclamationControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReclamationController controller = (ReclamationController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "reclamationController");
            return controller.getReclamation(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Reclamation) {
                Reclamation o = (Reclamation) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Reclamation.class.getName()});
                return null;
            }
        }

    }

    public List<Reclamation> methodRecValid(){
            items = ejbFacade.findReclamationValid();
            return items;
        
    }
    public List<Reclamation> methodRecNnValid(){
            items = ejbFacade.findReclamationNonTraiter();
            return items;
        
    }
    public List<Reclamation> methodRecAll(){
            items = ejbFacade.findAll();
            return items;
        
    }
    public List<Reclamation> getReclamationsAdmin() {
        if (reclamationsAdmin == null) {
            reclamationsAdmin = getFacade().findReclamationNonTraiter();
        }
        return reclamationsAdmin;
    }

    public void setReclamationsAdmin(List<Reclamation> reclamationsAdmin) {
        this.reclamationsAdmin = reclamationsAdmin;
    }

    public List<Reclamation> getReclamValid() {
         if (reclamValid== null) {
            reclamValid = getFacade().findReclamationValid();
        }
        return reclamValid;
    }

    public void setReclamValid(List<Reclamation> reclamValid) {
        this.reclamValid = reclamValid;
    }

    
}
