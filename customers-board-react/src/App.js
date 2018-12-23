import React, { Component } from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./components/Header";
import CustomersBoard from "./components/CustomersBoard";
import { BrowserRouter as Router } from "react-router-dom";
import AddCustomers from "./components/NewCustomers/AddCustomers";
import { Provider } from "react-redux";
import store from "./store";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <AddCustomers/>
            <CustomersBoard/>
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
