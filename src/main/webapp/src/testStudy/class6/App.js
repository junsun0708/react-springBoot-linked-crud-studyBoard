import logo from '../../logo.svg';
import '../../App.css';

import React, { Component } from 'react';
import 'tui-grid/dist/tui-grid.css';
import Grid from '@toast-ui/react-grid';

const data = [
  { id: 1, name: 'Editor' },
  { id: 2, name: 'Grid' },
  { id: 3, name: 'Chart' }
];

const columns = [
  { name: 'id', header: 'ID' },
  { name: 'name', header: 'Name' }
];

const MyComponent = () => (
  <Grid
    data={data}
    columns={columns}
    rowHeight={25}
    bodyHeight={100}
    heightResizable={true}
    rowHeaders={['rowNum']}
  />

);

class App extends Component {
  gridRef = React.createRef();

  handleAppendRow = () => {
    this.gridRef.current.getInstance().appendRow({});
  };

  render() {
    return (
      <>
        <Grid ref={this.gridRef} data={data} columns={columns} />
        <button onClick={this.handleAppendRow}>Append Row</button>
      </>
    );
  }
}

export default App;

