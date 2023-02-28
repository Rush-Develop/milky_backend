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

function LoginModal() {
  const [open, setOpen] = useState(false);
  const [Id, setId] = useState("");
  const [username, setUsername] = useState("");
  const [avatar, setAvatar] = useState("");

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
        setId(data.id);
        setUsername(data.name);
        setAvatar(data.avatar);
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
  const styled = {
    "&.MuiButton-text": {
      color: "white",
    },
  };

  return (
    <div className={styles.headprofile}>
      {Id === "" ? (
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
              src={`https://cdn.discordapp.com/avatars/${Id}/${avatar}.jpg`}
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
                  src={`https://cdn.discordapp.com/avatars/${Id}/${avatar}.jpg`}
                  alt="my"
                  width={"70px"}
                />
              </header>
              <h1 className={styles.boldtext}>
                {username}
                {/* <span className={styles.normaltext}>age</span> */}
              </h1>
              <h2 className={styles.normaltext}>정보0</h2>
              <div className={styles.socialcontainer}>
                <div className={styles.followers}>
                  <h1 className={styles.boldtext}>정보1</h1>
                  <h2 className={styles.smallertext}>정보1</h2>
                </div>
                <div className={styles.likes}>
                  <h1 className={styles.boldtext}>정보2</h1>
                  <h2 className={styles.smallertext}>정보2</h2>
                </div>
                <div className={styles.photos}>
                  <h1 className={styles.boldtext}>정보3</h1>
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
        // {/* <span className={styles.profile}>{props.username}님 안녕하세요!</span> */}
      )}
    </div>
  );
}

export default LoginModal;
