import styles from "../components/css/home.module.css";
import Menu from "./elements/Menu";
import LoginModal from "./elements/LoginModal";
import { useMediaQuery } from "react-responsive";
import Sidebar from "./elements/Sidebar";
import Sidemenu from "./elements/Sidemenu";
import React, { useEffect, useState } from "react";
import DiscordLoginModal from "./elements/DiscordLogin";
// import DiscordLogin from "./elements/DiscordLogin";

export const Small = ({ children }) => {
  const isSmall = useMediaQuery({
    query: "(max-width:981px)",
  });
  return <>{isSmall && children}</>;
};

export const Big = ({ children }) => {
  const isBig = useMediaQuery({
    query: "(min-width:980px)",
  });
  return <>{isBig && children}</>;
};

function Header() {
  return (
    <>
      <Small>
        <div className={styles.Header}>
          {/* <img
        className={styles.Logo}
        src="assets/img/logo.jpeg"
        alt="logo"
        style={{
          width: 100,
          height: 75,
          margin: 0,
          padding: 0,
        }}
      /> */}
          <span className={styles.Logo}>Logo</span>
          <LoginModal />
          {/* <DiscordLoginModal /> */}
          <Sidebar width={360}>
            <Sidemenu />
          </Sidebar>
        </div>
      </Small>
      <Big>
        <div className={styles.Header}>
          {/* <img
        className={styles.Logo}
        src="assets/img/logo.jpeg"
        alt="logo"
        style={{
          width: 100,
          height: 75,
          margin: 0,
          padding: 0,
        }}
      /> */}
          <span className={styles.Logo}>Logo</span>
          <Menu />
          <LoginModal />
          {/* <DiscordLoginModal /> */}
        </div>
      </Big>
    </>
  );
}

export default Header;
