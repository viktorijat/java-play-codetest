import axios from "axios";
import {
  GET_CUSTOMERS
} from "./types";

export const addNewCustomers = (customers_item, history) => async dispatch => {
  console.log("addNewCustomers customers_item", customers_item);
  try {
    await axios.post("http://localhost:8080/customers", customers_item.fileContent, {
      headers: {'Content-Type': 'application/json'}
    }).then(function(response) {
      console.log("response", response);
      dispatch({
        type: GET_CUSTOMERS,
        payload: response.data
      });
    });
    console.log(customers_item);
  } catch (error) {
    alert(error);
  }
};