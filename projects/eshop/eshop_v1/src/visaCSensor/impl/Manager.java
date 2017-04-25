package visaCSensor.impl;

import visaCSensor.impl.ISensorUpdaterManagerFacade;
import visaCSensor.prov.ISensorUpdaterManager;
import visaCSensor.prov.IManager;
import visaCSensor.req.IVisaManager;
import visaCSensor.req.ISensorUpdater;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaCSensor
 *
 * This class is a part of the VisaCSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaCSensor'. 
 */
class Manager implements IManager, visaCSensor.impl.IInterfaceTags {

    private Hashtable<String, Object> providedInterfaces = new Hashtable<String, Object>();
    private Hashtable<String, Object> requiredInterfaces = new Hashtable<String, Object>();

    private Hashtable<String, Class<?>> providedInterfacesTypesMap =
        new Hashtable<String, Class<?>>();
    private Hashtable<String, Class<?>> requiredInterfacesTypesMap =
        new Hashtable<String, Class<?>>();

    Manager() {
        //provided
        this.setProvidedInterface(IManagerProv, this);
        this.setProvidedInterfaceTypes(IManagerProv, IManager.class);

        this.setProvidedInterface(ISensorUpdaterManagerProv, new ISensorUpdaterManagerFacade(this));
        this.setProvidedInterfaceTypes(ISensorUpdaterManagerProv, ISensorUpdaterManager.class);

        //required
        this.setRequiredInterfaceTypes(ISensorUpdaterReq, ISensorUpdater.class);
        this.setRequiredInterfaceTypes(IVisaManagerReq, IVisaManager.class);
    }

    private void setProvidedInterface(String name, Object facade) {
        providedInterfaces.put(name, facade);
    }

    private void setProvidedInterfaceTypes(String name, Class<?> type) {
        providedInterfacesTypesMap.put(name, type);
    }

    @Override public synchronized void setRequiredInterface(String name, Object facade) {
        requiredInterfaces.put(name, facade);
    }

    //special
    private void setRequiredInterfaceTypes(String name, Class<?> type) {
        this.requiredInterfacesTypesMap.put(name, type);
    }

    @Override public synchronized Object getProvidedInterface(String name) {
        return this.providedInterfaces.get(name);
    }

    @Override public synchronized Object getRequiredInterface(String name) {
        return this.requiredInterfaces.get(name);
    }

    @Override public synchronized String[] getProvidedInterfaceNames() {
        return convertEnumToArray(providedInterfacesTypesMap.keys());
    }

    @Override public synchronized String[] getRequiredInterfaceNames() {
        return convertEnumToArray(requiredInterfacesTypesMap.keys());
    }

    @Override public synchronized Map<String, Class<?>> getProvidedInterfaceTypes() {
        return providedInterfacesTypesMap;
    }

    @Override public synchronized Map<String, Class<?>> getRequiredInterfaceTypes() {
        return requiredInterfacesTypesMap;
    }


    private String[] convertEnumToArray(Enumeration<String> stringEnum) {
        Vector<String> stringVector = new Vector<String>();
        for (Enumeration<String> iter = stringEnum; iter.hasMoreElements(); ) {
            String element = (String) iter.nextElement();
            stringVector.addElement(element);
        }

        String[] stringArray = new String[stringVector.size()];
        for (int i = 0; i < stringVector.size(); i++) {
            stringArray[i] = (String) stringVector.elementAt(i);
        }
        return stringArray;
    }
}