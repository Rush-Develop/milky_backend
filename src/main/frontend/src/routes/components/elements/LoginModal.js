import React, { useEffect, useRef, useState } from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import Zoom from "@mui/material/Zoom";
import styles from "../css/home.module.css";

const Transition = React.forwardRef(function Transition(props, ref) {
  return <Zoom timeout={1000} ref={ref} {...props} />;
});

function LoginModal() {
  const [open, setOpen] = useState(false);
  const [id, setId] = useState(null);
  const [username, setUsername] = useState(null);
  const [avatar, setAvatar] = useState(null);
  const [goon, setGoon] = useState(null);
  const [age, setAge] = useState(null);
  const [point, setPoint] = useState(null);

  useEffect(() => {
    fetch("/api/logininfo")
      .then((response) => {
        if (response.ok) {
          return response.json();
        }
        throw new Error("Network response was not ok.");
      })
      .then((data) => {
        console.log(JSON.stringify(data));
        if (data.goon == null || data.age == null) {
          setOpen(true);
        }
        setId(data.id);
        setUsername(data.name);
        setAvatar(data.avatar);
        setGoon(data.goon);
        setAge(data.age);
        setPoint(data.point);
      })
      .catch((error) => {
        console.log(`error: ${error}`);
      });
  }, []);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleSummit = (event) => {
    event.preventDefault();
    // const formData = new FormData();
    // formData.append("id", id);
    // formData.append("name", username);
    // formData.append("age", age);
    // formData.append("goon", goon);
    // console.log(formData);
    const userdata = { id: id, name: username, age: age, goon: goon };
    console.log(userdata);
    fetch(`/api/member/update/${id}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(userdata),
    })
      .then((response) => {
        if (response.ok === true) {
          return response.json();
        }
        throw new Error("에러 발생!");
      })
      .catch((error) => {
        alert(error);
      })
      .then((data) => {
        console.log(data);
      });
    // handleClose();
  };

  const handleChangegoon = (event) => {
    setGoon(event.target.value);
  };

  const handleChangename = (event) => {
    setUsername(event.target.value);
  };

  const handleChangeage = (event) => {
    setAge(event.target.value);
  };

  const styled = {
    "&.MuiButton-text": {
      color: "white",
    },
  };

  return (
    <div className={styles.headprofile}>
      {id === null ? (
        <a
          id="login"
          href="http://localhost:8080/oauth2/authorization/discord"
          style={{ textDecoration: "none" }}
        >
          <Button variant="text" sx={styled}>
            Log-in
          </Button>
        </a>
      ) : (
        <span className={styles.profile}>
          <Button
            variant="contained"
            className={styles.button}
            sx={{ borderRadius: 28 }}
            onClick={handleClickOpen}
          >
            <img
              src={`https://cdn.discordapp.com/avatars/${id}/${avatar}.jpg`}
              alt="my"
              width={"70px"}
            />
          </Button>
          <Dialog
            open={open}
            onClose={handleClose}
            TransitionComponent={Transition}
          >
            {/* <DialogTitle>Profile</DialogTitle> */}
            <DialogContent style={{ width: "450px", padding: "0" }}>
              {/* <div className={styles.cardcontainer}> */}
              <header className={styles.header}>
                <img
                  className={styles.profileimg}
                  src={`https://cdn.discordapp.com/avatars/${id}/${avatar}.jpg`}
                  alt="my"
                  width={"70px"}
                />
              </header>
              <h1 className={styles.boldtext}>
                <TextField
                  required
                  id="outlined-required"
                  onChange={handleChangename}
                  label="닉네임"
                  defaultValue={username}
                  variant="standard"
                  sx={{
                    width: 300,
                    textAlign: "center",
                  }}
                />
              </h1>
              <div className={styles.socialcontainer}>
                <h1 className={styles.boldtext}>
                  <FormControl
                    variant="standard"
                    sx={{
                      minWidth: 100,
                      minHeight: 0,
                      // border: "1px solid red",
                    }}
                  >
                    <InputLabel>군</InputLabel>
                    <Select
                      labelId="demo-simple-select-standard-label"
                      id="demo-simple-select-standard"
                      value={goon}
                      onChange={handleChangegoon}
                      label="Age"
                    >
                      <MenuItem value={0}>강주력</MenuItem>
                      <MenuItem value={1}>주력</MenuItem>
                      <MenuItem value={2}>1군</MenuItem>
                      <MenuItem value={3}>2군</MenuItem>
                      <MenuItem value={4}>3군</MenuItem>
                    </Select>
                  </FormControl>
                </h1>
                <h1 className={styles.boldtext}>
                  <TextField
                    required
                    InputProps={{
                      inputProps: {
                        style: { textAlign: "Center" },
                      },
                    }}
                    id="standard-required"
                    label="나이"
                    onChange={handleChangeage}
                    defaultValue={age}
                    variant="standard"
                    sx={{
                      width: 100,
                      textAlign: "center",
                      // border: "1px solid red",
                    }}
                  />
                  {/* <TextField
                    autoFocus
                    margin="dense"
                    id="name"
                    label="Email Address"
                    type="email"
                    fullWidth
                    variant="standard"
                    sx={{
                      width: 100,
                      textAlign: "center",
                    }}
                  /> */}
                </h1>
                <h1 className={styles.boldtext}>
                  <TextField
                    required
                    id="standard-required"
                    label="포인트"
                    defaultValue={point}
                    variant="standard"
                    InputProps={{
                      readOnly: true,
                      inputProps: {
                        style: { textAlign: "Center" },
                      },
                    }}
                    sx={{
                      width: 100,
                      textAlign: "center",
                    }}
                  />
                </h1>
              </div>
            </DialogContent>
            <DialogActions>
              {/* <Button onClick={handleClose}>Cancel</Button> */}
              <Button onClick={handleSummit}>수정완료</Button>
            </DialogActions>
          </Dialog>
        </span>
      )}
    </div>
  );
}

export default LoginModal;
