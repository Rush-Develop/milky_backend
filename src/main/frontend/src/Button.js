import Proptypes from "prop-types";
import styled from "./Button.module.css";

function Button({ text }) {
  return (
    <button
      //   style={{
      //     backgroundColor: "purple",
      //   }}
      className={styled.btn}
    >
      {text}
    </button>
  );
}

Button.prototype = {
  text: Proptypes.string.isRequired,
};

export default Button;
