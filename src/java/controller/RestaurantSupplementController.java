package controller;

import bean.RestaurantSupplement;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.RestaurantSupplementFacade;

import java.io.Serializable;
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

@Named("restaurantSupplementController")
@SessionScoped
public class RestaurantSupplementController implements Serializable {

    @EJB
    private service.RestaurantSupplementFacade ejbFacade;
    private List<RestaurantSupplement> items = null;
    private RestaurantSupplement selected;

    public RestaurantSupplementController() {
    }

    public RestaurantSupplement getSelected() {
        return selected;
    }

    public void setSelected(RestaurantSupplement selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RestaurantSupplementFacade getFacade() {
        return ejbFacade;
    }

    public RestaurantSupplement prepareCreate() {
        selected = new RestaurantSupplement();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RestaurantSupplementCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RestaurantSupplementUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RestaurantSupplementDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RestaurantSupplement> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
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

    public RestaurantSupplement getRestaurantSupplement(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<RestaurantSupplement> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RestaurantSupplement> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RestaurantSupplement.class)
    public static class RestaurantSupplementControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RestaurantSupplementController controller = (RestaurantSupplementController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "restaurantSupplementController");
            return controller.getRestaurantSupplement(getKey(value));
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
            if (object instanceof RestaurantSupplement) {
                RestaurantSupplement o = (RestaurantSupplement) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RestaurantSupplement.class.getName()});
                return null;
            }
        }

    }

}
