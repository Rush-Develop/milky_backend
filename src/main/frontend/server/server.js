const path = require("path");
const express = require("express");

const app = express();

app.use("", express.static(path.join(__dirname, "public")));

app.get("/", (request, response) => {
  return response.sendFile("main.html", { root: "." });
});

app.get("/auth/discord", (request, response) => {
  return response.redirect("http://localhost:3000");
});

app.post("/idplz", (req, res) => {
  const serverid = req.body.plzid;
  console.log(serverid);
});

const port = "3001";
app.listen(port, () =>
  console.log(`App listening at http://localhost:${port}`)
);
