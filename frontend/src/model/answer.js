import {EventEmitter} from "events";
import RestClient from "../rest/RestClient";

const client = new RestClient("a","a");

var tempDate = new Date();
var dateTime = tempDate.getFullYear() + '-' + (tempDate.getMonth() + 1) + '-' + tempDate.getDate() + ' ' + tempDate.getHours() + ':' + tempDate.getMinutes() + ':' + tempDate.getSeconds();

class Answer extends EventEmitter{
    constructor(){
        super();
        this.state = {
            answers: [],
            newAnswer:{
                answerId: -1,
                userId: 49,
                questionId: -1,
                text: "",
                creationDate: dateTime
            },
            answersOfQuestion: []
        }
    }

    addAnswer(answerId, userId, questionId, text, creationDate){
        return client.createAnswer(answerId, userId, questionId, text, creationDate)
            .then(answer => this.appendAnswer(answer));
    }

    appendAnswer(answer){
        this.state = {
            ...this.state,
            answers: this.state.answers.concat([answer])
        }
        this.emit("change", this.state);
    }

    changeNewAnswerProperty(property, value){
        this.state = {
            ...this.state,
            newAnswer: {
                ...this.state.newAnswer,
                [property]: value
            }
        };
        this.emit("change", this.state)
    }

    loadAllAnswers(){
        return client.loadAllAnswers().then(
            answers => {
                this.state = {
                    ...this.state,
                    answers: answers
                }
                this.state.emit("change", this.state);
            }
        )
    }

    listOnQuestionId(questionId){
        return client.loadAnswersOnQuestion(questionId).then(
            answers => {
                this.state = {
                    ...this.state,
                    answersOfQuestion: answers
                }
                this.state.emit("change", this.state);
            }
        )
    }
}
const answer = new Answer();

export default answer;