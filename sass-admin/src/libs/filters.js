import { getDateFormat } from "@/libs/util";

const timeFilter = value => {
  if (value) {
    value = Number(value);
    return getDateFormat(value, "yyyy-MM-dd hh:mm:ss");
  }
};
export default { timeFilter };
