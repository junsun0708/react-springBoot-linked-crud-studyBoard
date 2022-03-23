import '../../App.css';

import React, { Component } from 'react';
import 'tui-grid/dist/tui-grid.css';
import Grid from '@toast-ui/react-grid';

/*
const data = [
  { id: 1, name: 'Editor' },
  { id: 2, name: 'Grid' },
  { id: 3, name: 'Chart' }
];*/

const dataSource = {
  api: {
    //readData: { url: '/api/read', method: 'GET', initParams: { param: 'param' } }
    readData: { url: '/user/readData', method: 'GET', initParams: { param: 'param' } }
  }
};

const columns = [
  //{ name: 'id', header: 'ID' },
  // { name: 'name', header: 'Name' }

  { header: "USID", name: "usid" }
  , {
    header: "이름", name: "name", sortingType: 'desc', sortable: true
  }
  , { header: "부서", name: "dept" }
  , { header: "팀", name: "team" }
  , { header: "담당업무", name: "duty_c" }
  , { header: "이메일", name: "email" }
  , { header: "전화번호", name: "phone_number" }
];

const MyComponent = () => (
  <Grid
    data={dataSource}
    columns={columns}
    rowHeight={25}
    bodyHeight={100}
    heightResizable={true}
    rowHeaders={['rowNum']}
  />

);
//////////select end

class App extends Component {
  gridRef = React.createRef();

  handleAppendRow = () => {
    this.gridRef.current.getInstance().appendRow({});
  };

  render() {
    return (
      <>
        <Grid ref={this.gridRef} data={dataSource} columns={columns} />
        <button onClick={this.handleAppendRow}>Append Row</button>
      </>
    );
  }
}

export default App;

