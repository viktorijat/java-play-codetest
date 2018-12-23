import React, {Component} from "react";
import CustomersItem from "./NewCustomers/CustomersItem";
import {connect} from "react-redux";
import PropTypes from "prop-types";

class CustomersBoard extends Component {

    render() {
        const {customers_list} = this.props.customers_list;

        let BoardContent;
        const BoardAlgorithm = customers_list => {
            if (customers_list === undefined) {
                return (
                    <div className="alert alert-info text-center" role="alert">
                        Added customers will appear here
                    </div>
                );
            } else {
                const customersMapped = customers_list.map(customers_item => (
                    <CustomersItem key={customers_item.id} customers_item={customers_item}/>
                ));

                return (
                    <React.Fragment>

                        <table className="table table-striped thread-light">
                            <tbody>
                            <tr className="row thead-light">
                                <td className="col">ID</td>
                                <td className="col">Name</td>
                                <td className="col">Duetime</td>
                                <td className="col">Jointime</td>
                            </tr>
                            {customersMapped}
                            </tbody>
                        </table>
                    </React.Fragment>
                );
            }
        };

        BoardContent = BoardAlgorithm(customers_list);

        return (
            <div className="container">
                <br/>
                <br/>
                {BoardContent}
            </div>
        );
    }
}

CustomersBoard.propTypes = {
    customers_list: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
    customers_list: state.customers_item
});

export default connect(mapStateToProps)(CustomersBoard);
