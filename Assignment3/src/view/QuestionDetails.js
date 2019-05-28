import React from "react";

const QuestionDetails = ({questionId, userId, title, text, creationDate, tags}) => (
    <div>
        <h2>Question</h2>
        <label>questionid: </label>
        <span>{questionId}</span>
        <br />
        <label>userid: </label>
        <span>{userId}</span>
        <br />
        <label>title: </label>
        <span>{title}</span>
        <br />
        <label>text: </label>
        <span>{text}</span>
        <br />
        <label>creationdate: </label>
        <span>{creationDate}</span>
        <br />
        <label>tags: </label>
        <span>{tags}</span>
    </div>
);

export default QuestionDetails;