import React from "react";

const CreateAnswer = ({questionId, text, onCreate, onChange}) => (    
<div>
        <h2>Answer Question</h2>
        <div>
            <label>Question id:</label>
            <input value = {questionId}
                onChange={e => onChange("questionId", e.target.value)}/>
            <br />
            <label>Text: </label>
            <input value = {text}
                onChange ={e => onChange("text", e.target.value)} />
            <br />
            <button onClick = {onCreate}>Create</button>
        </div>
    </div>
);

export default CreateAnswer;