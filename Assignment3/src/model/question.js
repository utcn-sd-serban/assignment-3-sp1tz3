import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";

const client = new RestClient("a","a");

var tempDate = new Date();
var dateTime = tempDate.getFullYear() + '-' + (tempDate.getMonth() + 1) + '-' + tempDate.getDate() + ' ' + tempDate.getHours() + ':' + tempDate.getMinutes() + ':' + tempDate.getSeconds();

class Question extends EventEmitter{
    constructor(){
        super();
        this.state = {
            questions: [],
            newQuestion:{
                questionId: -1,
                userId: 1,
                title: "",
                text: "",
                creationDate: dateTime,
                tags: [],
            },
            filter:"",
            filteredQuestions: []
        }
    }

    addQuestion(questionId, userId, title, text, tags){
        return client.createQuestion(questionId, userId, title, text, tags)
            .then(question => {
                this.state = {
                    ...this.state,
                    questions: this.state.questions.concat([question])
                }
                this.emit("change", this.state);
            })
       
    }

    changeNewQuestionProperty(property, value){
        this.state = {
            ...this.state,
            newQuestion: {
                ...this.state.newQuestion,
                [property]: value
            }
        };
        this.emit("change", this.state);
    }

    changeProperty(property, value){
        this.state ={
            ...this.state,
            [property]: value
        }
    }

    loadQuestions(){
        return client.loadAllQuestions().then(questions => {
            this.state = {
                ...this.state, 
                questions: questions
            };
            this.emit("change", this.state);
        })
    }

    filterByTitle(){
        debugger;
        return client.filterByTitle(this.state.filter).then(questions =>{
            this.state = {
                ...this.state,
                filteredQuestions: questions
            }
            this.emit("change", this.state);
        })
    }

    filterByTag(){
        return client.filterByTag(this.state.filter).then(questions =>{
            this.state = {
                ...this.state,
                filteredQuestions: questions
            }
            this.emit("change", this.state);
        })
    }
}

const question = new Question();

export default question;