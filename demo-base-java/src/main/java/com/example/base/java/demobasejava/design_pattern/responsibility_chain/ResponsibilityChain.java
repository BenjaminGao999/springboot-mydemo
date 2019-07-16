package com.example.base.java.demobasejava.design_pattern.responsibility_chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benjamin
 * created at 2019/7/16
 */
public class ResponsibilityChain {

    //存放具体的责任逻辑
    private List<Responsibility> responsibilitys;

    private int index = 0;

    public ResponsibilityChain() {
        this.responsibilitys = new ArrayList<>();
    }

    //顺序调用加入的责任逻辑，一个处理完以后交给下一个继续处理，下一个处理完以后会通过this回调process看是否有下一个继续处理
    public void process(Request request) {
        if (this.index < this.responsibilitys.size()) {
            this.responsibilitys.get(index++).process(request, this);
        }
    }

    //加入具体的责任逻辑
    public void register(Responsibility res) {
        this.responsibilitys.add(res);
    }
}

