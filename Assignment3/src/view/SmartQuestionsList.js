import React, { Component } from 'react';
import question from "../model/question";
import QuestionsList from "./QuestionsList";
import questionListPresenter from "../presenter/questionListPresenter";

const mapModelStateToComponentState = modelState => ({
    questions: modelState.questions,
});

export default class SmartQuestionsList extends Component{
    constructor(){
        super();
        this.state = mapModelStateToComponentState(question.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        question.addListener("change", this.listener);
        questionListPresenter.onInit();
    }
    


    componentWillUnmount(){
        question.removeListener("change", this.listener);
    }

    render(){
        return (
            <QuestionsList
                questions={this.state.questions}
                onCreateQuestion={questionListPresenter.onCreateQuestion}
                onViewDetails={questionListPresenter.onViewDetails} 
                filter={this.state.filter}
                onChangeFilter={questionListPresenter.onChange}
                onFilterByTitle={questionListPresenter.onFilterByTitle}
                onFilterByTag={questionListPresenter.onFilterByTag}
            />
        );
    }
}