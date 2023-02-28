const path = require("path");
const express = require("express");

const app = express();

app.use("", express.static(path.join(__dirname, "public")));

app.get("/", (request, response) => {
  return response.sendFile("main.html", { root: "." });
});

app.get("/login/oauth2/code/discord", (request, response) => {
  console.log(response);
  //이 사이에 이제 DB랑 BACK에 넘겨준 response랑 비교해서 회원이 되있으면 redirect
  return response.redirect("http://localhost:3000");
});

const port = "8080";
app.listen(port, () =>
  console.log(`App listening at http://localhost:${port}`)
);
