import question from "../model/question";

class QuestionListPresenter {
    
    onCreateQuestion(){
        window.location.assign("#/create-question");
    }

    onViewDetails(index){
        window.location.assign("#/question-details/" + index);
    }

    onFilterByTitle(){
        question.filterByTitle();
        window.location.assign("#/filterTitle/");
    }

    onFilterByTag(){
        question.filterByTag();
        window.location.assign("#/filterTag/");
    }

    onInit(){
        question.loadQuestions();
    }

    onChange(property, value){
        question.changeProperty(property, value);
    }
}

const questionListPresenter = new QuestionListPresenter();

export default questionListPresenter;