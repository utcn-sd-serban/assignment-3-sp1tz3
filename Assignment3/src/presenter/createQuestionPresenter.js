import question from "../model/question";

class CreateQuestionPresenter {
    onCreate(){
    
        question.addQuestion(
            question.state.newQuestion.questionId,
            question.state.newQuestion.userId,
            question.state.newQuestion.title,
            question.state.newQuestion.text,
            question.state.newQuestion.creationDate,
            question.state.newQuestion.tags,
        );
        question.changeNewQuestionProperty("questionId", NaN);
        question.changeNewQuestionProperty("userId", 1);
        question.changeNewQuestionProperty("title", "");
        question.changeNewQuestionProperty("text", "");
        question.changeNewQuestionProperty("creationDate", "");
        question.changeNewQuestionProperty("tags", []);
        window.location.assign("#/");
    }

    onChange(property, value){
        question.changeNewQuestionProperty(property, value); 
    }
}

const createQuestionPresenter = new CreateQuestionPresenter();

export default createQuestionPresenter;