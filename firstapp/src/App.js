import './App.css';
import LoginPage from "./Pages/LoginPage";
import React from "react";
import Appbar from "./Components/AppTopBar";
import SignupPage from "./Pages/SignupPage";
import {BrowserRouter as Router, Switch,Link} from "react-router-dom";
import HomePage from "./Pages/HomePage";
import {Route,Routes,redirect} from "react-router-dom";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import {LocalizationProvider} from "@mui/x-date-pickers";
import ForgotPasswordPage from "./Pages/ForgotPasswordPage"
import {Navigate} from "react-router";

function App() {
    return (
        <div className="App">
            <Appbar/>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
            <Routes>
                    <Route exact path="/" element={<HomePage/>} />
                    <Route exact path="/login" element={<LoginPage/>} />
                    <Route exact path="/signup"  element={<SignupPage/> }/>
                    <Route exact path="/forgotPassword" element={<ForgotPasswordPage />} />
                    <Route
                        path="*"
                        element={<Navigate to="/" replace />}
                    />

            </Routes>
            </LocalizationProvider>
        </div>
    );
}

export default App;
