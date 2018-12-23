import {
  GET_CUSTOMERS,
} from "../actions/types";

const initialState = {
  customers_list: [],
  customers_item: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_CUSTOMERS:
      return {
        ...state,
        customers_list: action.payload
      };
    default:
      return state;
  }
}
