<template>
  <div>
    <List>
      <ListItem>
        <ListItemMeta :title="detail.memberName" :description="description">
          <div class="avatar-wrapper" slot="avatar">
            <img :src="detail.avatar" class="avatar" alt="头像" />
          </div>
        </ListItemMeta>
      </ListItem>
    </List>
    <CellGroup>
      <Divider dashed></Divider>
      <Cell>
        <div>
          微信二维码：
          <img :src="detail.qrCode" class="qrcode" alt="微信二维码" />
        </div>
      </Cell>

      <Cell>
        <span>手机：{{ detail.mobile }}</span>
      </Cell>
      <Cell>
        <span>座机：{{ detail.telephone }}</span>
      </Cell>
      <Cell>
        <span>邮箱：{{ detail.mail }}</span>
      </Cell>
      <Cell>
        <span>地址：{{ detail.address }}</span>
      </Cell>
      <Divider dashed></Divider>
      <Cell>
        <span>部门：{{ departments }}</span>
      </Cell>
      <Cell>
        <span>职位：{{ detail.memberPosition }}</span>
      </Cell>
      <Cell>
        <span
          >状态：{{ $mapd("staffAccountState", detail.status) }}({{
            $mapd("memberStatus", detail.memberStatus)
          }})</span
        >
      </Cell>
      <Divider dashed></Divider>
      <Button type="primary" @click="hdlClick">会话信息</Button>
    </CellGroup>
  </div>
</template>

<script>
export default {
  name: "staff-detail",
  props: {
    items: Object
  },
  computed: {
    description() {
      return `账号：${this.detail.userId}`;
    },
    departments() {
      return this.detail.departments
        ? this.detail.departments.map(n => n.departmentName).join(",")
        : "";
    }
  },
  data() {
    return {
      showRecord: false,
      detail: {
        avatar: "",
        memberName: "",
        userId: "",
        mobile: "",
        address: "",
        mail: "",
        mainDepartmentName: "",
        telephone: "",
        memberPosition: "",
        extension: "",
        qrCode: "",
        memberStatus: "",
        status: "",
        departments: []
      }
    };
  },
  methods: {
    hdlCancel() {
      this.$emit("on-cancel");
    },
    hdlClick() {
      this.$emit("show-record", this.detail.userId);
    }
  },
  watch: {
    items: {
      immediate: true,
      deep: true,
      handler(newValue) {
        this.detail = newValue;
      }
    }
  }
};
</script>
<style lang="less" scoped>
img:after {
  content: "\f1c5""" attr(alt);
  font-size: 12px;
  color: rgb(100, 100, 100);
  display: block;
  position: absolute;
  z-index: 2;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: #fff;
}
img[src=""],
img:not([src]) {
  opacity: 0;
}
fieldset,
img {
  border: none;
  background-color: white;
}
.avatar-wrapper {
  position: relative;
  float: left;
  width: 60px;
  height: 60px;
}
.qrcode {
  vertical-align: top;
  width: 80px;
  height: 80px;
  border: none;
}
.avatar {
  vertical-align: top;
  width: 100%;
  height: 100%;
  border: none;
}
.avatar-wrapper:after {
  content: " ";
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  border: 1px solid rgba(0, 0, 0, 0.1);
}
</style>
