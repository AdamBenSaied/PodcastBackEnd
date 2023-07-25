import {default as React, useEffect, useState} from "react";
import Container from "@mui/material/Container";
import Paper from "@mui/material/Paper";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField/TextField";
import PasswordButton from "./PasswordInput";


const MAX_LENGTH = 12

export default function UsernameInput(props) {
    // const [username, setUsername] = useState("");
    const [helperTextMessage, sethelperTextMessage] = useState("Must be under 12 characters");

    useEffect(() => {
        if (props.pseudoname.length >= MAX_LENGTH) {
            sethelperTextMessage("12 characters exceeded");
        }
    }, [props.pseudoname]);

    useEffect(() => {
        if (props.pseudoname.length < MAX_LENGTH && helperTextMessage) {

            sethelperTextMessage("Must be under 12 characters");
        }
    }, [props.pseudoname, helperTextMessage]);




    return (
        <div>

            <Box
                component="form"
                sx={{
                    '& .MuiTextField-root': {m: 1, width: '25ch'},
                }}
                noValidate
                autoComplete="off"
            >
                <div>
                    <TextField
                        required={true}
                        error={props.pseudoname.length >= MAX_LENGTH}
                        helperText={helperTextMessage}
                        label="Pseudoname"
                        value={props.pseudoname}
                        onChange={(event => props.setPseudoname(event.target.value))}
                    />
                </div>

            </Box>
        </div>
    );

}