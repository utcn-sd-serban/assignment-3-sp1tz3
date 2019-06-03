import React, { Component } from 'react';
import question from "../model/question";
import CreateQuestion from './CreateQuestion';
import createQuestionPresenter from '../presenter/createQuestionPresenter';

const mapModelStateToComponentState = modelState => ({
    title: modelState.newQuestion.title,
    text: modelState.newQuestion.text,
    tags: modelState.newQuestion.tags
});

export default class SmartCreateQuestion extends Component{
    constructor(){
        super();
        this.state = mapModelStateToComponentState(question.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        question.addListener("change", this.listener);
    }

    componentWillUnmount(){
        question.removeListener("change", this.listener);
    }

    render(){
        return (
            <CreateQuestion
                title={this.state.title} 
                text={this.state.text}
                tags={this.state.tags}
                onCreate={createQuestionPresenter.onCreate}
                onChange={createQuestionPresenter.onChange}/>
        );
    }
}