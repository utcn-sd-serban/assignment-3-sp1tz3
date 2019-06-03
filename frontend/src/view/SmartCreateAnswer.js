import React, {Component} from "react";
import CreateAnswer from "./CreateAnswer";
import answer from "../model/answer";
import createAnswerPresenter from "../presenter/createAnswerPresenter";

const mapModelStateToComponentState = modelState => ({
    questionId: modelState.newAnswer.questionId,
    text: modelState.newAnswer.text
})

export default class SmartCreateAnswer extends Component{
    constructor(){
        super();
        this.state = mapModelStateToComponentState(answer.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        answer.addListener("change", this.listener);
    }

    componentWillUnmount(){
        answer.removeListener("change", this.listener);
    }

    render(){
        return (
            <CreateAnswer
                questionId = {this.state.questionId}
                text = {this.state.text}
                onCreate = {createAnswerPresenter.onCreate}
                onChange = {createAnswerPresenter.onChange}/>
        );
    }
}