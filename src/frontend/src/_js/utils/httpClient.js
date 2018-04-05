import _axios from "axios";

export default httpClient = _axios.create({
  //TODO: Get some setting file.
  baseURL: "http://localhost:9000",
  headers: { 'X-Requested-With': 'XMLHttpRequest' }
});
