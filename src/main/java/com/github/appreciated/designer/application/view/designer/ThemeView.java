package com.github.appreciated.designer.application.view.designer;

import com.github.appreciated.designer.application.view.BaseView;
import com.github.appreciated.designer.application.view.designer.theme.ColorStyleView;
import com.github.appreciated.designer.application.view.designer.theme.OtherStyleView;
import com.github.appreciated.designer.application.view.designer.theme.SizeAndSpaceStyleView;
import com.github.appreciated.designer.application.view.designer.theme.TypographyStyleView;
import com.github.appreciated.designer.component.ironpages.IronPages;
import com.github.appreciated.designer.service.EventService;
import com.github.appreciated.designer.service.ProjectService;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class ThemeView extends BaseView {

    private Tabs tabs;
    private IronPages content;

    public ThemeView(ProjectService projectService, EventService eventService) {
        super("Theme");
        if (projectService.getProject().hasThemeFile()) {
            ColorStyleView colorStyleView = new ColorStyleView(projectService, eventService);
            TypographyStyleView typographyView = new TypographyStyleView(projectService, eventService);
            SizeAndSpaceStyleView sizeAndSpaceStyleView = new SizeAndSpaceStyleView(projectService, eventService);
            OtherStyleView otherStyleView = new OtherStyleView(projectService, eventService);

            tabs = new Tabs();
            Tab colorTab = new Tab(VaadinIcon.PALETE.create(), new Label("Color"));
            Tab typographyTab = new Tab(VaadinIcon.FONT.create(), new Label("Typography"));
            Tab sizeTab = new Tab(VaadinIcon.BACKSPACE.create(), new Label("Size & Space"));
            Tab otherTab = new Tab(VaadinIcon.EDIT.create(), new Label("Other"));
            tabs.add(colorTab, typographyTab, sizeTab, otherTab);
            add(tabs);
            content = new IronPages();
            content.setSizeFull();
            content.add(colorStyleView, typographyView, sizeAndSpaceStyleView, otherStyleView);
            add(content);
            tabs.setWidthFull();
            tabs.addSelectedChangeListener(selectedChangeEvent -> content.setSelected(tabs.getSelectedIndex()));
            tabs.setSelectedTab(colorTab);
        } else {
            add(new Label("There was no theme file found!"));
        }
    }
}