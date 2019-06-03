import React from 'react';

const AnswerList = ({answers}) => (
    <div>
        <h2>Answers</h2>
        <table border ='1'>
            <thead>
                <tr>
                    <th>AnswerId: </th>
                    <th>QuestionId: </th>
                    <th>Text: </th>
                    <th>UserId: </th>
                </tr>
            </thead>
            <tbody>
                {
                    answers.map((answer, index) => (
                        <tr key ={index}>
                            <td>{answer.answerId}</td>
                            <td>{answer.questionId}</td>
                            <td>{answer.text}</td>
                            <td>{answer.userId}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>

    </div>
);

export default AnswerList