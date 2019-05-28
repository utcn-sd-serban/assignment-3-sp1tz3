import React, { Component } from 'react';
import question from "../model/question";
import QuestionDetails from "./QuestionDetails";

const mapModelStateToComponentState = (questionState, props) => ({
    question: questionState.questions[props.match.params.index]
})

export default class SmartQuestionDetails extends Component{
    constructor(props){
        super(props);
        this.state = mapModelStateToComponentState(question.state, props);
        this.listener = modelState => this.setState(mapModelStateToComponentState(question.state, this.props));
        question.addListener("change", this.listener);
    }

    componentDidUpdate(prev){
        if(prev.match.params.index !== this.props.match.params.index){
            this.setState(mapModelStateToComponentState(question.state,this.props))
        }
    }

    componentWillUnmount(){
        question.removeListener("change", this.listener);
    }

    render(){
        debugger;
        return (
            <QuestionDetails
                questionId={this.state.question.questionId}
                userId={this.state.question.userId}
                title={this.state.question.title} 
                text={this.state.question.text}
                creationDate={this.state.question.creationDate}
                tags={this.state.question.tags}
                />
        );
    }
}