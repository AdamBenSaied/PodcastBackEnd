import * as React from 'react';
import TextField from '@mui/material/TextField';
import {useState} from "react";
import PasswordButton from "../Components/PasswordInput";
import Container from "@mui/material/Container";
import Paper from "@mui/material/Paper";
import UsernameInput from "../Components/UsernameInput";
import EmailInput from "../Components/EmailInput";
import DOBPage from "./DOBPage";
import Button from "@mui/material/Button";
import Alert from "@mui/material/Alert";
import Snackbar from "@mui/material/Snackbar/Snackbar";
import {Link} from "react-router-dom";
import api from "../api/posts";
import {useNavigate} from "react-router";


const SUCCESS_RESPONSE = "User Created Successfully"
const ERROR_RESPONSE = "There was some problem with the creation of the account, please retry"


export default function SignupPage() {
    const paperStyle = {padding: "20px 50px", width: 500, margin: "20px auto"}
    let navigate = useNavigate();

    const [pseudoname, setPseudoname] = useState("")
    const [password, setPassword] = useState("")
    const [email, setEmail] = useState("")
    const [dob, setDob] = useState("");
    const [firstname, setFirstname] = useState("");
    const [surname, setSurname] = useState("");

    const [message, setMessage] = useState("");

    const [openSnackbar, setOpenSnackbar] = useState(false);

    const handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }

        setOpenSnackbar(false);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await api.post("/user/user_create",
                {
                    pseudoname: pseudoname,
                    password: password,
                    mail: email,
                    dob: dob,
                    name: firstname,
                    surname: surname
                })
            navigate("/")
            setOpenSnackbar(true);
            setMessage(SUCCESS_RESPONSE)
            console.log(response.data);
        } catch (err) {
            console.log("Error :${err.message}");
            setOpenSnackbar(true)
            setMessage(ERROR_RESPONSE)
        }
    }


    return (
        <Container>
            <h1>SIGNUP PAGE NIK OMMEK</h1>

            <div>

                <form onSubmit={handleSubmit}>
                    <Paper elevation={5} style={paperStyle}>
                        <TextField required={true}
                                   autoFocus={true}
                                   value={firstname}
                                   onChange={(event => setFirstname(event.target.value))}


                                   label="First name"
                        />

                        <TextField required={true}
                                   value={surname}
                                   onChange={(event => setSurname(event.target.value))}


                                   label="Surname"
                        />

                        <UsernameInput pseudoname={pseudoname} setPseudoname={setPseudoname}/>
                        <PasswordButton password={password} setPassword={setPassword}/>
                        <EmailInput email={email} setEmail={setEmail}/>
                        <DOBPage dob={dob} setDob={setDob}/>

                        <Button variant="contained" type="submit">Create my account</Button>

                        <Snackbar open={openSnackbar} autoHideDuration={4000} onClose={handleClose}>
                            <Alert onClose={handleClose}
                                   severity={message === SUCCESS_RESPONSE ? "success" : "error"}
                                   sx={{width: '100%'}}>
                                {message}
                            </Alert>
                        </Snackbar>

                        <Link to="/login"> Have an account already ?</Link>
                    </Paper>
                </form>

            </div>
        </Container>
    )
        ;
}
