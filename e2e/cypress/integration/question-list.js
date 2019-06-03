describe("The Question list", function(){
    beforeEach(function(){
        cy.request("http://localhost:8080/test/reseed")
            .its("stats").should("be.equal", 200);
    });

    it("should show 1 questions", function(){
        cy.visit("/");
        cy.get('[data-cy="question"]').should("have.length", 1);
    })

    it("should add a new question", function(){
        cy.visit("/");
        
        cy.get('[data-cy="add"]').first().click();
        cy.get('[data-cy="title"]').type("Testerino");
        cy.get('[data-cy="text"]').type("Testantionados");
        cy.get('[data-cy="tags"]').type("TestoTagoAmigo");
        cy.get('[data-cy="createQuestion"]').click();
        cy.get('[data-cy="question"]').should("have.length", 2)
            .and("contain", "Testerino");
    })
})