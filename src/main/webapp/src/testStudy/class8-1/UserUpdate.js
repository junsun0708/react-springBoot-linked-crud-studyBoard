import React, { useState, useEffect } from "react";
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import { useParams } from 'react-router-dom';

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

export default function UserUpdate() {
    const classes = useStyles();

    const { usid } = useParams();
    console.log(usid);
    useEffect(() => {
        fetch("/user/updateData" + usid)
            .then(res => res.json())
            .then(
                (result) => {
                    setName(result.user.name)
                    setDept(result.user.dept)
                    setTeam(result.user.team)
                    setEmail(result.user.email)
                }
            )
    }, [usid])

    const handleSubmit = event => {
        event.preventDefault();
        var data = {
            'usid': usid,
            'name': name,
            'dept': dept,
            'team': team,
            'email': email,
            //'avatar': avatar,
        }
        fetch('/user/updateData', {
            method: 'PUT',
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

    const [name, setName] = useState('');
    const [dept, setDept] = useState('');
    const [team, setTeam] = useState('');
    const [email, setEmail] = useState('');

    return (
        <Container maxWidth="xs">
            <div className={classes.paper}>
                <Typography component="h1" variant="h5">
                    User
                </Typography>
                <form className={classes.form} onSubmit={handleSubmit}>
                    <Grid container spacing={2}>
                        <Grid item xs={12} sm={6}>
                            <TextField
                                //autoComplete="name"
                                name="dept"
                                variant="outlined"
                                required
                                fullWidth
                                id="dept"
                                label="dept"
                                value={dept}
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
                                value={team}
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
                                value={name}
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
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                            />
                        </Grid>
                    </Grid>
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        className={classes.submit}
                    >
                        Update
                    </Button>
                </form>
            </div>
        </Container>
    );
}