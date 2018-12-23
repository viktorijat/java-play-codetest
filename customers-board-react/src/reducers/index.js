import { combineReducers } from "redux";
import projectTaskReducer from "./customersReducer";

export default combineReducers({
  customers_item: projectTaskReducer
});
