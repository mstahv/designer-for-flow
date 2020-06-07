package com.github.appreciated.designer.application.presenter.file;

import com.github.appreciated.designer.application.model.file.ProjectFileModel;
import com.github.appreciated.designer.application.presenter.file.designer.DesignerWrapperPresenter;
import com.github.appreciated.designer.application.presenter.file.designer.SideBarPresenter;
import com.github.appreciated.designer.application.view.file.ProjectFileView;
import com.github.appreciated.designer.model.DesignCompilerInformation;
import com.github.appreciated.designer.service.EventService;
import com.github.appreciated.mvp.Presenter;

public class ProjectFilePresenter extends Presenter<ProjectFileModel, ProjectFileView> {
    public ProjectFilePresenter(DesignCompilerInformation information, EventService eventService) {
        super(new ProjectFileModel(information, eventService));
        DesignerWrapperPresenter designerView = new DesignerWrapperPresenter(getModel());
        getContent().getComponentsAndTemplate().setSplitterPosition(25);
        getContent().getComponentsAndTemplate().addToSecondary(designerView);
        getContent().addToPrimary(getContent().getComponentsAndTemplate());
        getContent().addToSecondary(new SideBarPresenter(getModel()));
    }
}