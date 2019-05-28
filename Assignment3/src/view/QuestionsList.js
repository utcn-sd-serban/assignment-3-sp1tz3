import React from 'react';

const QuestionsList = ({questions, onCreateQuestion,onViewDetails,filter,onChangeFilter,onFilterByTitle,onFilterByTag}) => (
    <div>
        <h2>Questions</h2>
        <table border = '1'>
            <thead>
                <tr>
                    <th>Title: </th>
                    <th>Text : </th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {
                    questions.map((question, index) => (
                        <tr key={index}>
                            <td>{question.title}</td>
                            <td>{question.text}</td>
                            <td><button onClick={() => onViewDetails(index)}>View Details</button></td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
        <button onClick = {onCreateQuestion}>Ask new Question</button>
        <br />
        <input value ={filter} onChange={e=> onChangeFilter("filter",e.target.value)} />
        <br />
        <button onClick = {onFilterByTitle}>FilterByTitle</button>
        <br />
        <button onClick = {onFilterByTag}>FilterByTag</button>

    </div>
);

export default QuestionsList;