import * as React from 'react';
import {DatePicker} from '@mui/x-date-pickers/DatePicker';


export default function DOBPage({dob,setDob}) {


    return (
        <div>
            <DatePicker
                disableFuture={true} label="Date of birth"
                        value={dob}
            onChange={(newValue) => setDob(newValue)}
            />
        </div>
    );
}