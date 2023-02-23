import { useEffect, useState } from "react";
import styles from "../css/home.module.css";

function TopButton() {
  const [showButton, setShowButton] = useState(false);

  const scrollToTop = () => {
    window.scroll({
      top: 0,
      behavior: "smooth",
    });
  };
  useEffect(() => {
    const handleShowButton = () => {
      if (window.scrollY > 500) {
        setShowButton(true);
      } else {
        setShowButton(false);
      }
    };

    // console.log(window.scrollY);
    window.addEventListener("scroll", handleShowButton);
    return () => {
      window.removeEventListener("scroll", handleShowButton);
    };
  }, []);

  return (
    showButton && (
      <div className={styles.scroll__container}>
        <button className={styles.top} onClick={scrollToTop} type="button">
          {" "}
          Top
        </button>
      </div>
    )
  );
}

export default TopButton;
