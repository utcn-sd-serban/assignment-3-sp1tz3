const BASE_URL = "http://localhost:8080";

export default class RestClient{
    constructor(username, password){
        this.authorization = "Basic " + btoa(username + ":" + password); 
    }

    loadAllQuestions(){
        return fetch(BASE_URL + "/questions",{
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    createQuestion(questionId, userId, title, text, creationDate, tags){
        return fetch(BASE_URL + "/questions",{
            method: "POST",
            body: JSON.stringify({
                questionId: questionId,
                userId: userId,
                title: title,
                text:text,
                creationDate: creationDate,
                tags: tags
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => response.json());
    }

    filterByTitle(title){
        debugger;
        return fetch(this.BASE_URL + "/questions/filterTitle/" + title, {
            method: "GET",
            headers:{
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    filterByTag(tag){
        return fetch(this.BASE_URL + "/questions/filterTag/" + tag, {
            method: "GET",
            headers:{
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }
}