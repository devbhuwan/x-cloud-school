export class GridViewConfig {
  sortable: boolean;
  filterable: boolean;
  bulkTasks: GridBulkTask[];
  columns: GridColumn[];
  pagination: GridPagination;
}

export class GridColumn {
  type: string;
  faIcon: string;
}

export class GridBulkTask {

}

export class GridPagination {
  pageSize: number;
  currentPage: number;
  totalRows: number;
}
