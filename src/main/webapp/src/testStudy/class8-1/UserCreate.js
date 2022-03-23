import React, { useState } from "react";
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';

const useStyles = makeStyles((theme) => ({
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(3),
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
    },
}));

export default function UserCreate() {
    const classes = useStyles();

    const handleSubmit = event => {
        event.preventDefault();
        var data = {
            'usid': usid,
            'name': name,
            'dept': dept,
            'team': team,
            'email': email,
        }
        fetch('/user/createData', {
            method: 'POST',
            headers: {
                Accept: 'application/form-data',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            //.then(res => res.json())
            .then(
                (result) => {
                    alert(result['message'])
                    if (result['status'] === 'ok') {
                        window.location.href = '/';
                    }
                }
            )
    }

    const [usid, setUsid] = useState('');
    const [name, setName] = useState('');
    const [dept, setDept] = useState('');
    const [team, setTeam] = useState('');
    const [email, setEmail] = useState('');
    //const [avatar, setAvatar] = useState('');
    return (
        <Container maxWidth="xs">
            <div className={classes.paper}>
                <Typography component="h1" variant="h5">
                    User
                </Typography>
                <form className={classes.form} onSubmit={handleSubmit}>
                    <Grid container spacing={2}>
                        <Grid item xs={12}>
                            <TextField
                                variant="outlined"
                                required
                                fullWidth
                                id="usid"
                                label="usid"
                                onChange={(e) => setUsid(e.target.value)}
                            />
                        </Grid>
                        <Grid item xs={12} sm={6}>
                            <TextField
                                autoComplete="name"
                                name="firstName"
                                variant="outlined"
                                required
                                fullWidth
                                id="dept"
                                label="dept"
                                onChange={(e) => setDept(e.target.value)}
                                autoFocus
                            />
                        </Grid>
                        <Grid item xs={12} sm={6}>
                            <TextField
                                variant="outlined"
                                required
                                fullWidth
                                id="team"
                                label="team"
                                onChange={(e) => setTeam(e.target.value)}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                variant="outlined"
                                required
                                fullWidth
                                id="name"
                                label="name"
                                onChange={(e) => setName(e.target.value)}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                variant="outlined"
                                required
                                fullWidth
                                id="email"
                                label="Email"
                                onChange={(e) => setEmail(e.target.value)}
                            />
                        </Grid>
                        {/* <Grid item xs={12}>
                            <TextField
                                variant="outlined"
                                required
                                fullWidth
                                id="avatar"
                                label="Avatar"
                                onChange={(e) => setAvatar(e.target.value)}
                            />
                        </Grid> */}
                    </Grid>
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        className={classes.submit}
                    >
                        Create
                    </Button>
                </form>
            </div>
        </Container>
    );
}