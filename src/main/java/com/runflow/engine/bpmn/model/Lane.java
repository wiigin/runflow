package com.runflow.engine.bpmn.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;

public class Lane extends BaseElement {

    protected String name;
    protected Process parentProcess;
    protected List<String> flowReferences = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonBackReference
    public Process getParentProcess() {
        return parentProcess;
    }

    public void setParentProcess(Process parentProcess) {
        this.parentProcess = parentProcess;
    }

    public List<String> getFlowReferences() {
        return flowReferences;
    }

    public void setFlowReferences(List<String> flowReferences) {
        this.flowReferences = flowReferences;
    }

    public Lane clone() {
        Lane clone = new Lane();
        clone.setValues(this);
        return clone;
    }

    public void setValues(Lane otherElement) {
        super.setValues(otherElement);
        setName(otherElement.getName());
        setParentProcess(otherElement.getParentProcess());

        flowReferences = new ArrayList<String>();
        if (otherElement.getFlowReferences() != null && !otherElement.getFlowReferences().isEmpty()) {
            flowReferences.addAll(otherElement.getFlowReferences());
        }
    }
}
