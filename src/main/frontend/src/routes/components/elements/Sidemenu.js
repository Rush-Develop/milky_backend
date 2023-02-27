import styled from "styled-components";
import { Link } from "react-scroll";
import Button from "@mui/material/Button";

function Sidemenu() {
  const StyledLink = styled(Link)`
    box-sizing: border-box;
    display: block;
    padding: 30px;
    margin: 0 auto;
    text-align: center;
  `;
  const styles = {
    "&.MuiButton-text": {
      color: "white",
    },
  };
  return (
    <div>
      <StyledLink to="1" spy={true} smooth={true}>
        <span>
          <Button variant="text" sx={styles}>
            Section1
          </Button>
        </span>
      </StyledLink>
      <StyledLink to="2" spy={true} smooth={true}>
        <span>
          <Button variant="text" sx={styles}>
            Section2
          </Button>
        </span>
      </StyledLink>
      <StyledLink to="3" spy={true} smooth={true}>
        <span>
          <Button variant="text" sx={styles}>
            Section3
          </Button>
        </span>
      </StyledLink>
      <StyledLink to="4" spy={true} smooth={true}>
        <span>
          <Button variant="text" sx={styles}>
            Section4
          </Button>
        </span>
      </StyledLink>
    </div>
  );
}
export default Sidemenu;
