import React, { Component } from "react";
import moment from "moment";

class CustomersItem extends Component {

  render() {
    const { customers_item } = this.props;
    let formatter = "hh:mm:ss - DD MMMM YYYY";
    let duetime = moment(customers_item.duetime).format(formatter);
    let jointime = moment(customers_item.jointime).format(formatter);

    return (
      <tr className="row thead-light">
        <td className="col">{customers_item.id}</td>
        <td className="col">{customers_item.name}</td>
        <td className="col">{duetime}</td>
        <td className="col">{jointime}</td>
      </tr>
    );
  }
}

export default (CustomersItem);
