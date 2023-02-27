import React, { useEffect, useRef, useState } from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
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

function LoginModal(props) {
  const [open, setOpen] = useState(false);
  const [username, setUsername] = useState("");

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };
  const styled = {
    "&.MuiButton-text": {
      color: "white",
    },
  };

  // if (props.id === undefined) {
  // } else {
  //   console.log(props.id);
  //   console.log(props.username);
  //   console.log(props.avatar);
  // }

  return (
    <div className={styles.headprofile}>
      {props.id === undefined ? (
        <a
          id="login"
          href="https://discord.com/api/oauth2/authorize?client_id=1060823658832076830&redirect_uri=http%3A%2F%2Flocalhost%3A3001%2Fauth%2Fdiscord&response_type=token&scope=identify"
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
              src={`https://cdn.discordapp.com/avatars/${props.id}/${props.avatar}.jpg`}
              alt="my"
              width={"70px"}
            />
          </Button>
          <Dialog
            open={open}
            onClose={handleClose}
            TransitionComponent={Transition}
          >
            <DialogTitle>Profile</DialogTitle>
            <DialogContent style={{ width: "450px" }}>
              {/* <div className={styles.cardcontainer}> */}
              <header className={styles.header}>
                <img
                  className={styles.profileimg}
                  src={`https://cdn.discordapp.com/avatars/${props.id}/${props.avatar}.jpg`}
                  alt="my"
                  width={"70px"}
                />
              </header>
              <h1 className={styles.boldtext}>
                {props.username}
                <span className={styles.normaltext}>{props.age}</span>
              </h1>
              <h2 className={styles.normaltext}>{props.city}</h2>
              <div className={styles.socialcontainer}>
                <div className={styles.followers}>
                  <h1 className={styles.boldtext}>{props.followers}</h1>
                  <h2 className={styles.smallertext}>정보1</h2>
                </div>
                <div className={styles.likes}>
                  <h1 className={styles.boldtext}>{props.likes}</h1>
                  <h2 className={styles.smallertext}>정보2</h2>
                </div>
                <div className={styles.photos}>
                  <h1 className={styles.boldtext}>{props.photos}</h1>
                  <h2 className={styles.smallertext}>정보3</h2>
                </div>
              </div>
              {/* </div> */}
            </DialogContent>
            <DialogActions>
              {/* <Button onClick={handleClose}>Cancel</Button>
              <Button onClick={handleClose}>Login</Button> */}
            </DialogActions>
          </Dialog>
        </span>
        // <span className={styles.profile}>{props.username}님 안녕하세요!</span>
      )}
    </div>
  );
}

export default LoginModal;
