import React, {Component} from "react";
import PropTypes from "prop-types";
import {connect} from "react-redux";
import {addNewCustomers} from "../../actions/customersActions";

class AddCustomers extends Component {
    constructor() {
        super();
        this.state = {
            summary: "",
            fileName: "",
            fileContent: "",
            enabledSubmitFile: false,
            enabledSubmitText: false
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.onFileSelected = this.onFileSelected.bind(this);
    }

    onChange(e) {
        this.setState({[e.target.name]: e.target.value, enabledSubmitText: true});
    }

    onSubmit(e) {
        e.preventDefault();
        const newProjectTask = {
            summary: this.state.summary,
            fileContent: this.state.fileContent
        };
        this.props.addCustomers(newProjectTask, this.props.history);
    }

    onFileSelected(e) {
        let fileNameSelected = "";
        try {
            fileNameSelected = e.target.files[0].name;
            this.setState({fileName: fileNameSelected, enabledSubmitFile: true});
            let reader = new FileReader();
            reader.readAsText(e.target.files[0]);
            reader.onload = (e) => {
                this.setState({fileContent: e.target.result});
            };
        } catch (e) {
        }
    }

    render() {
        return (
            <div className="addCustomers">
                <div className="container">
                    <div className="row">
                        <div className="col-md-8 m-auto">
                            <h4 className="display-4 text-center">Add customers</h4>
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <input
                                        type="text"
                                        className="form-control form-control-lg"
                                        name="summary"
                                        value={this.state.summary}
                                        placeholder="Import New Customers"
                                        onChange={this.onChange}
                                    />
                                </div>
                                <input type="submit"
                                       className="btn btn-primary btn-block mt-4"
                                       disabled={!this.state.enabledSubmitText}/>
                            </form>
                            <br/>
                            <form onSubmit={this.onSubmit}>
                                <div className="form-group">
                                    <input
                                        type="file"
                                        accept="application/JSON"
                                        className="form-control form-control-lg"
                                        name="file"
                                        onChange={this.onFileSelected}
                                    />
                                    <input type="submit"
                                           className="btn btn-primary btn-block mt-4"
                                           disabled={!this.state.enabledSubmitFile}/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

AddCustomers.propTypes = {
    addCustomers: PropTypes.func.isRequired,
};

const mapStateToProps = state => ({});

export default connect(mapStateToProps, {addCustomers: addNewCustomers})(AddCustomers);