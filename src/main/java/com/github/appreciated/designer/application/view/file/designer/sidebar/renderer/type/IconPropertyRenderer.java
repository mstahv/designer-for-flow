package com.github.appreciated.designer.application.view.file.designer.sidebar.renderer.type;

import com.github.appreciated.designer.component.properties.PropertyComboBox;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;

import java.beans.PropertyDescriptor;

public class IconPropertyRenderer extends AbstractPropertyRenderer<Component> {

    @Override
    public boolean canRender(Component propertyParent, String propertyName, PropertyDescriptor propertyDescriptor) {
        return propertyDescriptor.getPropertyType() == Component.class && propertyName.equals("icon");
    }

    public Component render(String propertyName, PropertyDescriptor propertyDescriptor, Component propertyParent) {
        PropertyComboBox<VaadinIcon> icon = new PropertyComboBox<>();
        icon.setRenderer(new ComponentRenderer<>(item -> {
            HorizontalLayout container = new HorizontalLayout();
            container.add(item.create(), new Label(item.name()));
            return container;
        }));
        icon.setItems(VaadinIcon.values());
        icon.addValueChangeListener(comboBoxVaadinIconComponentValueChangeEvent ->
                applyValue(propertyParent, propertyDescriptor, comboBoxVaadinIconComponentValueChangeEvent.getValue().create())
        );
        return icon;
    }


}
