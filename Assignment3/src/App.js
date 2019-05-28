import React from 'react';
import './App.css';

import { HashRouter, Switch, Route } from "react-router-dom";
import SmartQuestionsList from './view/SmartQuestionsList';
import SmartCreateQuestion from './view/SmartCreateQuestion';
import SmartQuestionDetails from './view/SmartQuestionDetails';
import FilterQuestionsByTag from './view/FilterQuestionsByTag';
import FilterQuestionsByTitle from './view/FilterQuestionsByTitle';

const App = () => (
      <div className="App">
        <HashRouter>
          <Switch>
            <Route exact={true} component={SmartQuestionsList} path="/" />
            <Route exact={true} component={SmartCreateQuestion} path="/create-question" />
            <Route exact={true} component={SmartQuestionDetails} path="/question-details/:index" />
            <Route exact={true} component={FilterQuestionsByTitle} path="/filterTitle/" />
            <Route exact={true} component={FilterQuestionsByTag} path="/filterTag/" />
          </Switch>
        </HashRouter>
      </div>
);

export default App;