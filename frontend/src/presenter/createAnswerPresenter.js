import answer from "../model/answer";

class AnswerPresenter{

    onCreate(){
        answer.addAnswer(
            answer.state.newAnswer.answerId,
            answer.state.newAnswer.userId,
            answer.state.newAnswer.questionId,
            answer.state.newAnswer.text,
            answer.state.newAnswer.creationDate
        );
        answer.changeNewAnswerProperty("answerId", -1);
        answer.changeNewAnswerProperty("userId", 1);
        answer.changeNewAnswerProperty("questionId", -1);
        answer.changeNewAnswerProperty("text", "");
        answer.changeNewAnswerProperty("creationDate", "");
        window.location.assign("#/");
    };

    onChange(property, value){
        answer.changeNewAnswerProperty(property, value);
    }

    onAddAnswer(){
        window.location.assign("#/create-answer");
    }

    onInit(){
        answer.loadAllAnswers();
    }
}

const answerPresenter = new AnswerPresenter();

export default answerPresenter;