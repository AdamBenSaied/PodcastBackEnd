import Input from "@mui/material/Input";
import React, {useEffect, useState} from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField/TextField";



export default function EmailInput(props) {
    const [helperTextMessage, setHelperTextMessage] = useState("Provide a valid email")

                function isValidEmail(email) {
                return /\S+@\S+\.\S+/.test(email);
            }

                const handleChange = event => {
                if (!isValidEmail(event.target.value)) {
                setHelperTextMessage('Email is invalid');
            } else {
                setHelperTextMessage(null);
            }

                props.setEmail(event.target.value);
            };

                return (
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
                            error={helperTextMessage!== null && props.email.length>0}
                            helperText={helperTextMessage}
                            label="email"
                            value={props.email}
                            onChange={handleChange}
                        />

            </div>
        </Box>
    );
}