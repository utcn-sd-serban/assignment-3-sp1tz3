import React, { Component } from "react";
import question from "../model/question";
import QuestionsList from "./QuestionsList";
import questionListPresenter from "../presenter/questionListPresenter";

const mapModelStateToComponentState = (modelState) => ({
    questions: modelState.filteredQuestions,
    filter: modelState.filter,
});

export default class FilterQuestionsByTag extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(question.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        question.addListener("change", this.listener);
    }

    componentWillUnmount() {
        question.removeListener("change", this.listener);
    }

    render() {
        return (
            <QuestionsList
                questions={this.state.questions}
                onCreateQuestion={questionListPresenter.onCreateQuestion}
                onViewDetails={questionListPresenter.onViewDetails}
                onChange={questionListPresenter.onChange}
                filter={this.state.filter}
                onFilterByTag={questionListPresenter.onFilterByTag}
                onfilterByTitle={questionListPresenter.onfilterByTitle}
            />
        );
    }
}